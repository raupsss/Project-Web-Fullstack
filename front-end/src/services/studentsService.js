import http from "../http-common";

class studentsService {

    getAllStudents() {
        return http.get("/students/getAll");
    }

    insertStudents(data) {
        return http.post("/students/insert", data);
    }

    updateStudents(id, data) {
        return http.put(`/students/update/${id}`, data);
    }

    deleteStudents(id) {
        return http.delete(`/students/delete/${id}`);
    }

    getStudents(id) {
        return http.get(`/students/getStudents/${id}`);
    }
}


export default new studentsService();