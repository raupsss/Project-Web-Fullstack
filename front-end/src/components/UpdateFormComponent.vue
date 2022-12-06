<template>
  <div>
    <SuccessUpdate v-show="success" />
    <div v-show="!success">
      <router-link to="/">
        <button type="submit" class="btn btn-primary mt-3 ml-3">Back</button>
      </router-link>

      <div class="row justify-content-center my-5">
        <form
          @submit.prevent="updateStudentsFunc"
          class="col-8 border border-primary p-5"
        >
          <h1 class="text-center mb-5">Update Form</h1>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="name">Student Name</label>
              <input
                v-model="studentsData.nama"
                type="text"
                name="name"
                class="form-control"
                id="name"
                placeholder="Enter Name"
                required
              />
            </div>
            <div class="form-group col-md-6">
              <label for="soft_skill">Soft Skills</label>
              <input
                v-model="studentsData.soft_skill"
                type="text"
                name="soft_skill"
                class="form-control"
                id="soft_skill"
                placeholder="Enter Soft Skills"
                required
              />
            </div>
          </div>

          <div class="form-row">
            <div class="form-group col-md-3">
              <label for="umur">Student Age</label>
              <input
                v-model="studentsData.umur"
                type="number"
                name="umur"
                class="form-control"
                id="umur"
                placeholder="Enter Age"
                required
              />
            </div>
            <div class="form-group col-md-3">
              <label for="jenis_kelamin">Gender</label>
              <select
                v-model="studentsData.jenis_kelamin"
                name="jenis_kelamin"
                id="jenis_kelamin"
                class="form-control"
                required
              >
                <option selected value="">Choose Gender</option>
                <option>Male</option>
                <option>Female</option>
              </select>
            </div>
            <div class="form-group col-6">
              <label for="hard_skill">Hard Skills</label>
              <input
                v-model="studentsData.hard_skill"
                type="text"
                name="hard_skill"
                class="form-control"
                id="hard_skill"
                placeholder="Enter Hard Skills"
                required
              />
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="email">Student Email</label>
              <input
                v-model="studentsData.email"
                type="email"
                name="email"
                class="form-control"
                id="email"
                placeholder="Enter Email"
                required
              />
            </div>
            <div class="form-group col-md-6">
              <label for="interest">Interest</label>
              <select
                v-model="studentsData.interest"
                name="interest"
                id="interest"
                class="form-control"
                required
              >
                <option selected value="">Choose Interest</option>
                <option>Data Science</option>
                <option>Network</option>
                <option>Web Frontend</option>
                <option>Web Backend</option>
                <option>Mobile Apps</option>
              </select>
            </div>
            <div class="form-group col-md-12">
              <label for="deskripsi_diri">Self Description</label>
              <textarea
                v-model="studentsData.deskripsi_diri"
                name="deskripsi_diri"
                id="deskripsi_diri"
                class="form-control"
                cols="100%"
                required
              ></textarea>
            </div>
          </div>
          <button name="submitForm" type="submit" class="btn btn-primary">
            Update
          </button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import studentsService from "@/services/studentsService";
import SuccessUpdate from "../components/SuccessUpdate.vue";
export default {
  name: "UpdateFormComponent",
  data() {
    return {
      studentsData: {
        nama: null,
        soft_skill: null,
        umur: null,
        jenis_kelamin: null,
        hard_skill: null,
        email: null,
        interest: null,
        deskripsi_diri: null,
      },
      success: false,
    };
  },
  components: {
    SuccessUpdate,
  },

  methods: {
    updateStudentsFunc() {
      let data = this.studentsData;
      let id = this.$route.params.id;
      studentsService
        .updateStudents(id, data)
        .then((response) => {
          console.log(response.data);
          this.success = true;
        })
        .catch((e) => {
          console.log(e);
        });
    },

    getStudents() {
      let id = this.$route.params.id;
      studentsService
        .getStudents(id)
        .then((response) => {
          this.studentsData = response.data;
          console.log(this.studentsData);
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },

  mounted() {
    this.getStudents();
  },
};
</script>

<style>
</style>