<template>
  <div>
    <div v-show="!success">
      <div class="d-flex justify-content-between">
        <router-link to="/add">
          <button type="submit" class="btn btn-primary mt-3 ml-3">
            <font-awesome-icon icon="fa-solid fa-user-plus" />
            Add Data
          </button>
        </router-link>
        <form class="form-inline mr-3 mt-3">
          <input
            v-model="searchStudents"
            id="searchStudents"
            class="form-control mr-sm-2"
            type="search"
            placeholder="Search Student Name"
            aria-label="Search"
          />
        </form>
      </div>
      <h1 class="text-center mt-5" v-if="studentsData.length === 0">
        Data Not Found !
      </h1>
      <div class="row justify-content-center">
        <div class="row my-5 col-12">
          <!-- Card -->
          <div
            class="card-body border col-3 m-5 studentsItem"
            v-for="(item, index) in searchStudent"
            :key="index"
            style="border-radius: 20px"
          >
            <h5 class="card-title">
              {{ item.nama + ", " + item.umur + " Years Old" }}
            </h5>
            <p class="card-text">{{ item.deskripsi_diri }}</p>
            <table>
              <tr>
                <td>Email</td>
                <td>:&nbsp;{{ item.email }}</td>
              </tr>
              <tr>
                <td>Soft Skills</td>
                <td>:&nbsp;{{ item.soft_skill }}</td>
              </tr>
              <tr>
                <td>Hard Skills &nbsp;</td>
                <td>:&nbsp;{{ item.hard_skill }}</td>
              </tr>
              <tr>
                <td>Interest</td>
                <td>:&nbsp;{{ item.interest }}</td>
              </tr>
            </table>

            <div class="d-flex justify-content-between mt-3">
              <div>
                <router-link :to="{ path: '/update/' + item.id }">
                  <button class="btn btn-primary mr-2">
                    <font-awesome-icon icon="fa-solid fa-pen-to-square" />
                    Update
                  </button>
                </router-link>
                <router-link to="/">
                  <button
                    class="btn btn-danger"
                    @click="deleteStudentsFunc(item.id, item.nama)"
                  >
                    <font-awesome-icon icon="fa-solid fa-trash" />
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
    <SuccessComponent v-show="success" />
  </div>
</template>

<script>
import studentsService from "../services/studentsService";
import SuccessComponent from "../components/SuccessComponent.vue";
export default {
  name: "ViewDataComponent",
  data() {
    return {
      studentsData: [],
      success: false,
      searchStudents: "",
    };
  },

  components: {
    SuccessComponent,
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

    deleteStudentsFunc(id, nama) {
      if (confirm(`Yakin Ingin menghapus ${nama} ?`)) {
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

  computed: {
    searchStudent() {
      return this.studentsData.filter((item) =>
        item.nama.toLowerCase().includes(this.searchStudents.toLowerCase())
      );
    },
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