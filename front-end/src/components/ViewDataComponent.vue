<template>
  <div>
    <div v-show="!success">
      <router-link to="/add">
        <button type="submit" class="btn btn-primary mt-3 ml-3">
          Add Data
        </button>
      </router-link>
      <div class="row justify-content-center">
        <div class="row my-5 col-12">
          <!-- Card -->
          <div
            class="card-body border col-3 m-5"
            v-for="(item, index) in studentsData"
            :key="index"
          >
            <h5 class="card-title">
              {{ item.nama + ", " + item.umur + " Years Old" }}
            </h5>
            <p class="card-text">{{ item.deskripsi_diri }}</p>
            <p class="card-text">Email : {{ item.email }}</p>
            <p class="card-text">Soft Skills : {{ item.soft_skill }}</p>
            <p class="card-text">Hard Skills : {{ item.hard_skill }}</p>
            <p class="card-text">Interest : {{ item.interest }}</p>

            <div class="d-flex justify-content-between">
              <div>
                <router-link :to="{ path: '/update/' + item.id }">
                  <button class="btn btn-primary mr-2">Update</button>
                </router-link>
                <router-link to="/">
                  <button
                    class="btn btn-danger"
                    @click="deleteStudentsFunc(item.id)"
                  >
                    Delete
                  </button>
                </router-link>
              </div>
              <div>
                <img
                  class="male"
                  v-if="item.jenis_kelamin == 'Male'"
                  src="../assets/male.png"
                  alt=""
                />
                <img
                  class="female"
                  v-else-if="item.jenis_kelamin == 'Female'"
                  src="../assets/female.png"
                  alt=""
                />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <SuccessDelete v-show="success" />
  </div>
</template>

<script>
import studentsService from "../services/studentsService";
import SuccessDelete from "../components/SuccessDelete.vue";
export default {
  name: "ViewDataComponent",
  data() {
    return {
      studentsData: null,
      success: false,
    };
  },

  components: {
    SuccessDelete,
  },

  methods: {
    getStudents() {
      studentsService
        .getAllStudents()
        .then((response) => {
          this.studentsData = response.data;
          console.log(this.studentsData);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    deleteStudentsFunc(id) {
      if (confirm(`Yakin Ingin menghapus data ini ?`)) {
        studentsService
          .deleteStudents(id)
          .then((response) => {
            console.log(response.data);
          })
          .catch((e) => {
            console.log(e);
          });
        this.success = true;
      } else {
        alert("Hapus Dibatalkan");
      }
    },
  },

  mounted() {
    this.getStudents();
  },
};
</script>

<style scoped>
.male {
  width: 40px;
  /* height: 50px; */
}
.female {
  width: 30px;
}
</style>