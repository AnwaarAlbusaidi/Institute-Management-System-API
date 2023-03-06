package com.InstituteManagementSystem.Institute.Management.System.Service;

import com.InstituteManagementSystem.Institute.Management.System.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This class represents the service for managing the students of an institute.
 */
@Service
public class StudentService {

    List<Student> listOfStudent = new CopyOnWriteArrayList<>();

    int currrentID = 1;

    /**
     * Retrieves a list of all students.
     *
     * @return A List of Student objects representing all the students.
     */
    public List<Student> getListOfStudent() {
        return listOfStudent;
    }

    /**
     * Retrieves a specific student by their ID.
     *
     * @param id The ID of the student to retrieve.
     * @return A Student object representing the student with the given ID, or null if no student was found.
     */
    public Student getStudent(int id) {
        Optional<Student> foundStudent = listOfStudent.stream().filter(
                (student) -> {
                    return student.id == id;
                }).findFirst();

        if (foundStudent.isPresent())
            return foundStudent.get();
        else
            return null;
    }
    /**
     * Registers a new student.
     *
     * @param student The Student object representing the new student to be registered.
     * @return A Student object representing the newly registered student.
     */
    public Student registerStudent(Student student) {
        student.id = this.currrentID++;
        listOfStudent.add(student);
        return student;
    }

    /**
     * Updates an existing student's information.
     *
     * @param id             The ID of the student to be updated.
     * @param updatedStudent The updated Student object with the new information.
     * @return A Student object representing the updated student.
     */
    public Student updateStudent(int id, Student updatedStudent) {
        Student foundStudent = getStudent(id);
        foundStudent.name = updatedStudent.name;
        foundStudent.email = updatedStudent.email;

        return foundStudent;
    }

    /**
     * Deletes an existing student.
     *
     * @param id The ID of the student to be deleted.
     * @return A Student object representing the deleted student.
     */
    public Student deleteStudent(int id) {
        Student foundStudent = getStudent(id);
        listOfStudent.remove(foundStudent);
        return foundStudent;
    }

}
