package com.InstituteManagementSystem.Institute.Management.System.Controller;

import com.InstituteManagementSystem.Institute.Management.System.Model.Teacher;
import com.InstituteManagementSystem.Institute.Management.System.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The ManageTeacherController class handles HTTP requests related to teacher management
 * in the Institute Management System.
 */
@RestController
@RequestMapping(path = "api/teachers")
public class ManageTeacherController {

    @Autowired
    TeacherService teacherService;

    /**
     * Returns a list of all teachers in the system.
     */
    @GetMapping
    public List<Teacher> getAllTeacher() {
        return teacherService.getListOfTeacher();
    }

    /**
     * Returns the teacher with the specified ID.
     *
     * @param id The ID of the teacher to retrieve.
     * @return The teacher with the specified ID, or null if no such teacher exists.
     */
    @GetMapping(path = "/{id}")
    public Teacher getTeacher(@PathVariable(name = "id") int id) {
        return teacherService.getTeacher(id);
    }

    /**
     * Creates a new teacher in the system.
     *
     * @param teacher The teacher to create.
     * @return The created teacher.
     */
    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        teacherService.registerTeacher(teacher);
        return teacher;
    }

    /**
     * Updates the teacher with the specified ID.
     *
     * @param id             The ID of the teacher to update.
     * @param currentTeacher The updated information for the teacher.
     * @return The updated teacher.
     */
    @PutMapping(path = "/{id}")
    public Teacher updateTeacher(@PathVariable(name = "id") int id, @RequestBody Teacher currentTeacher) {
        Teacher updateTeacher = teacherService.getTeacher(id);
        updateTeacher.name = currentTeacher.name;
        updateTeacher.email = currentTeacher.email;
        updateTeacher.salary = currentTeacher.salary;
        return updateTeacher;
    }

    /**
     * Deletes the teacher with the specified ID.
     *
     * @param id The ID of the teacher to delete.
     * @return The deleted teacher.
     */
    @DeleteMapping(path = "/{id}")
    public Teacher deleteStudent(@PathVariable(name = "id") int id) {
        Teacher deletesTeacher = teacherService.getTeacher(id);
        teacherService.deleteTeacher(id);
        return deletesTeacher;
    }
}
