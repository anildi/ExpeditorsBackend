package expeditors.backend.service;

import expeditors.backend.dao.StudentDAO;
import expeditors.backend.dao.inmemory.InMemoryStudentDAO;
import expeditors.backend.dao.jpa.JPAStudentDAO;
import expeditors.backend.domain.Student;
import java.util.ArrayList;
import java.util.List;

/*
StudentService should allow users to perform basic create, update, delete operations on Students to a store.
2. StudentService should allow users to retrieve a Student by ID
3. StudentService should allow users to retrieve all Students.
 */
public class StudentService {

   List<String> lstr = new ArrayList<>();

   //private StudentDAO studentDAO = new InMemoryStudentDAO();
   private StudentDAO studentDAO = new JPAStudentDAO();
//   private InMemoryStudentDAO studentDAO = new InMemoryStudentDAO();
//   private JPAStudentDAO studentDAO = new JPAStudentDAO();

   public Student createStudent(Student student) {
      //Validate DOB
      //Other business logic

      //Save the student to a Store == what kind of store?
      Student insertedStudent = studentDAO.insert(student);

      return insertedStudent;
      //Return a result
   }

   public boolean deleteStudent(int id) {
      return studentDAO.delete(id);
   }

   public boolean updateStudent(Student student) {
      return studentDAO.update(student);
   }

   public Student getStudent(int id) {
      return studentDAO.findById(id);
   }

   public List<Student> getStudents() {
      return studentDAO.findAll();
   }

   //   public JPAStudentDAO getStudentDAO() {
//   public InMemoryStudentDAO getStudentDAO() {
   public StudentDAO getStudentDAO() {
      return studentDAO;
   }
}