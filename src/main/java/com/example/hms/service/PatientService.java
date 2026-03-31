package com.example.hms.service;

import com.example.hms.dto.PatientDto;
import com.example.hms.entity.Patient;
import com.example.hms.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientDto createPatient(PatientDto dto) {
        Patient patient = mapToEntity(dto);
        Patient saved = patientRepository.save(patient);
        return mapToDto(saved);
    }

    public List<PatientDto> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        return mapToDto(patient);
    }

    public PatientDto updatePatient(Long id, PatientDto dto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setGender(dto.getGender());
        patient.setDisease(dto.getDisease());
        patient.setAddress(dto.getAddress());
        patient.setPhoneNumber(dto.getPhoneNumber());

        Patient updated = patientRepository.save(patient);
        return mapToDto(updated);
    }

    public String deletePatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        patientRepository.delete(patient);
        return "Patient deleted successfully";
    }

    private Patient mapToEntity(PatientDto dto) {
        return Patient.builder()
                .id(dto.getId())
                .name(dto.getName())
                .age(dto.getAge())
                .gender(dto.getGender())
                .disease(dto.getDisease())
                .address(dto.getAddress())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }

    private PatientDto mapToDto(Patient patient) {
        return PatientDto.builder()
                .id(patient.getId())
                .name(patient.getName())
                .age(patient.getAge())
                .gender(patient.getGender())
                .disease(patient.getDisease())
                .address(patient.getAddress())
                .phoneNumber(patient.getPhoneNumber())
                .build();
    }
}