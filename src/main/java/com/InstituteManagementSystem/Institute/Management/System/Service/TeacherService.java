package com.InstituteManagementSystem.Institute.Management.System.Service;

import com.InstituteManagementSystem.Institute.Management.System.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 The TeacherService class is responsible for managing the operations related to Teachers.
 */
@Service
public class TeacherService {
    /**
     * The list of teachers managed by this service.
     */
    List<Teacher> listOfTeacher = new CopyOnWriteArrayList<>();

    /**
     * The current ID to assign to the next registered teacher.
     */
    int currrentID = 1;

    /**
     * Returns the list of all teachers.
     *
     * @return the list of all teachers
     */
    public List<Teacher> getListOfTeacher() {
        return listOfTeacher;
    }

    /**
     * Returns the teacher with the specified ID.
     *
     * @param id the ID of the teacher to retrieve
     * @return the teacher with the specified ID, or null if no teacher was found
     */
    public Teacher getTeacher(int id) {
        Optional<Teacher> foundTeacher = listOfTeacher.stream().filter(
                (teacher) -> {
                    return teacher.id == id;
                }).findFirst();
        if (foundTeacher.isPresent())
            return foundTeacher.get();
        else
            return null;
    }

    /**
     * Registers a new teacher.
     *
     * @param teacher the teacher to register
     * @return the registered teacher
     */
    public Teacher registerTeacher(Teacher teacher) {
        teacher.id = this.currrentID++;
        listOfTeacher.add(teacher);
        return teacher;
    }

    /**
     * Updates the details of a teacher with the specified ID.
     *
     * @param id the ID of the teacher to update
     * @param updatedteacher the updated details of the teacher
     * @return the updated teacher
     */
    public Teacher updateTeacher(int id, Teacher updatedteacher) {
        Teacher foundTeacher = getTeacher(id);
        foundTeacher.name = updatedteacher.email;

        return foundTeacher;
    }

    /**
     * Deletes the teacher with the specified ID.
     *
     * @param id the ID of the teacher to delete
     * @return the deleted teacher
     */
    public Teacher deleteTeacher(int id) {
        Teacher foundTeacher = getTeacher(id);
        listOfTeacher.remove(foundTeacher);
        return foundTeacher;
    }

}
