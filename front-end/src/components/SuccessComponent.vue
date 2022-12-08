<template>
  <div>
    <div class="row justify-content-center my-5">
      <div class="card-body border col-6">
        <h5 class="card-title">Success!</h5>
        <p class="card-text">
          Student data has been
          <strong>{{ message }}</strong>
        </p>
        <router-link
          class="btn btn-primary"
          to="/"
          v-if="message == 'Inputed!'"
        >
          Close
        </router-link>
        <router-link
          class="btn btn-primary"
          to="/"
          v-else-if="message == 'Updated!'"
        >
          Close
        </router-link>
        <button v-else class="btn btn-primary" @click="reloadPage">
          Close
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "SuccessComponent",
  data() {
    return {
      message: null,
    };
  },

  methods: {
    changeMessage() {
      let route = this.$route.fullPath;
      if (route === "/add") {
        this.message = "Inputed!";
      } else if (route === "/") {
        this.message = "Deleted!";
      } else {
        this.message = "Updated!";
      }
    },
    reloadPage() {
      location.reload();
    },
  },

  mounted() {
    this.changeMessage();
  },
};
</script>

<style>
</style>