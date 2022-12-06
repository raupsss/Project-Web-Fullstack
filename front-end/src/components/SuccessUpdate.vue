<template>
  <div>
    <div class="row justify-content-center mt-5">
      <div class="card-body border col-6">
        <h5 class="card-title">Success!</h5>
        <p class="card-text">Student data has been Updated!</p>
        <router-link to="/">
          <button type="submit" class="btn btn-primary">Close</button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "SuccessUpdate",
};
</script>

<style>
</style>