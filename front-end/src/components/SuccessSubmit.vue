<template>
  <div>
    <div class="row justify-content-center my-5">
      <div class="card-body border col-6">
        <h5 class="card-title">Success!</h5>
        <p class="card-text">Student data has been Inputed!</p>
        <router-link to="/">
          <button type="submit" class="btn btn-primary">Close</button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "SuccessSubmit",
};
</script>

<style>
</style>