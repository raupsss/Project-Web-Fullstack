<template>
  <div>
    <div class="row justify-content-center mt-5">
      <div class="card-body border col-6">
        <h5 class="card-title">Success!</h5>
        <p class="card-text">Student data has been Deleted!</p>
        <button @click="reload" type="submit" class="btn btn-primary">
          Close
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "SuccessDelete",
  methods: {
    reload() {
      location.reload();
    },
  },
};
</script>

<style>
</style>