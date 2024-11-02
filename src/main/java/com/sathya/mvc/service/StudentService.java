package com.sathya.mvc.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.mvc.Entities.ProductEntity;
import com.sathya.mvc.entity.StudentEntity;
import com.sathya.mvc.model.ProductModel;
import com.sathya.mvc.model.StudentModel;
import com.sathya.mvc.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Save new student data
    public void saveStudentData(StudentModel studentModel) {
        double fee = studentModel.getStudFee();
        double scholarship = calculateScholarship(fee, studentModel.getStudBranch());

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudName(studentModel.getStudName());
        studentEntity.setStudBranch(studentModel.getStudBranch());
        studentEntity.setStudClg(studentModel.getStudClg());
        studentEntity.setStudFee(studentModel.getStudFee());
        studentEntity.setStudPhoneNumber(studentModel.getStudPhoneNumber());
        studentEntity.setStudAddress(studentModel.getStudAddress());
        studentEntity.setStudScholarShip(scholarship);
        studentEntity.setJoinedOn(LocalDate.now());
        studentEntity.setJoinedBy(System.getProperty("user.name"));  // Capturing system user

        studentRepository.save(studentEntity);
    }

    // Retrieve all students
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    // Delete student by ID
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    // Retrieve student by ID
    public StudentEntity getStudentById(Long studId) {
        return studentRepository.findById(studId).orElse(null);
    }

    // Retrieve and map student to model by ID
    public StudentModel searchStudentById(Long studId) {
        Optional<StudentEntity> studentOp = studentRepository.findById(studId);
        StudentModel studentModel = new StudentModel();
        if (studentOp.isPresent()) {
            StudentEntity student = studentOp.get();
            studentModel.setStudBranch(student.getStudBranch());
            studentModel.setStudName(student.getStudName());
            studentModel.setStudFee(student.getStudFee());
            studentModel.setStudAddress(student.getStudAddress());
            studentModel.setStudClg(student.getStudClg());
            studentModel.setStudPhoneNumber(student.getStudPhoneNumber());
        }
        return studentModel;
    }

    // Update student data
    public void updateStudentData(Long studId, StudentModel studentModel) {
        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(studId);
        if (studentEntityOptional.isPresent()) {
            StudentEntity studentEntity = studentEntityOptional.get();
            double fee = studentModel.getStudFee();
            double scholarship = calculateScholarship(fee, studentModel.getStudBranch());

            studentEntity.setStudName(studentModel.getStudName());
            studentEntity.setStudFee(fee);
            studentEntity.setStudBranch(studentModel.getStudBranch());
            studentEntity.setStudAddress(studentModel.getStudAddress());
            studentEntity.setStudClg(studentModel.getStudClg());
            studentEntity.setStudScholarShip(scholarship);
            studentEntity.setStudPhoneNumber(studentModel.getStudPhoneNumber());

            studentRepository.save(studentEntity);
        }
    }

    // Scholarship calculation logic
    private double calculateScholarship(double fee, String category) {
        switch (category.toLowerCase()) {
            case "cse":
                return fee * 0.1;
            case "mech":
                return fee * 0.15;
            case "ece":
                return fee * 0.2;
            case "civil":
                return fee * 0.25;
            default:
                return 0.0;
        }
    }
}/*
    public void saveProductData(StudentModel studentModel){
		double fee = studentModel.getStudFee();
		String branch = studentModel.getStudBranch();
		double schlorship = 0.0; 
		
		 switch (branch.toLowerCase()) {
         case "cse":
        	 schlorship = fee * 0.1; 
             break;
         case "ece":
        	 schlorship = fee * 0.15;
             break;
         case "civil":
        	 schlorship = fee * 0.2;
             break;
         case "mech":
        	 schlorship = fee * 0.25;        	 
           break;
         default:
        	 return;
		 }	

		  StudentEntity studentEntity = new StudentEntity();
	        studentEntity.setStudName(studentModel.getStudName());
	        studentEntity.setStudBranch(studentModel.getStudBranch());
	        studentEntity.setStudClg(studentModel.getStudClg());
	        studentEntity.setStudFee(studentModel.getStudFee());
	        studentEntity.setStudPhoneNumber(studentModel.getStudPhoneNumber());
	        studentEntity.setStudAddress(studentModel.getStudAddress());
	        studentEntity.setStudScholarShip(schlorship);
	        studentEntity.setJoinedOn(LocalDate.now());
	        studentEntity.setJoinedBy(System.getProperty("user.name"));  // Capturing system user

	        studentRepository.save(studentEntity);
	    }
 // Retrieve all students
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    // Delete student by ID
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    // Retrieve student by ID
    public StudentEntity getStudentById(Long studId) {
        return studentRepository.findById(studId).orElse(null);
    }
    public StudentModel searchStudentById(Long studId) {
        Optional<StudentEntity> studentOp = studentRepository.findById(studId);
        StudentModel studentModel = new StudentModel();
        if (studentOp.isPresent()) {
            StudentEntity student = studentOp.get();
            studentModel.setStudBranch(student.getStudBranch());
            studentModel.setStudName(student.getStudName());
            studentModel.setStudFee(student.getStudFee());
            studentModel.setStudAddress(student.getStudAddress());
            studentModel.setStudClg(student.getStudClg());
            studentModel.setStudPhoneNumber(student.getStudPhoneNumber());
        }
        return studentModel;
    }
    // Update student data
    public void updateStudentData(Long studId, StudentModel studentModel) {
        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(studId);
        if (studentEntityOptional.isPresent()) {
            StudentEntity studentEntity = studentEntityOptional.get();
            double fee = studentModel.getStudFee();
    		String branch = studentModel.getStudBranch();
    		double schlorship = 0.0; 
    		
    		 switch (branch.toLowerCase()) {
             case "cse":
            	 schlorship = fee * 0.1; 
                 break;
             case "ece":
            	 schlorship = fee * 0.15;
                 break;
             case "civil":
            	 schlorship = fee * 0.2;
                 break;
             case "mech":
            	 schlorship = fee * 0.25;        	 
               break;
             default:
            	 return;
    		 }    	

            studentEntity.setStudName(studentModel.getStudName());
            studentEntity.setStudFee(fee);
            studentEntity.setStudBranch(studentModel.getStudBranch());
            studentEntity.setStudAddress(studentModel.getStudAddress());
            studentEntity.setStudClg(studentModel.getStudClg());
            studentEntity.setStudScholarShip(schlorship);
            studentEntity.setStudPhoneNumber(studentModel.getStudPhoneNumber());

            studentRepository.save(studentEntity);
        }
    }
}    */

