<template>
  <div>
    <HeaderComponent />
    <UpdateFormComponent />
    <FooterComponent />
  </div>
</template>

<script>
import HeaderComponent from "../components/HeaderComponent.vue";
import UpdateFormComponent from "../components/UpdateFormComponent.vue";
import FooterComponent from "../components/FooterComponent.vue";
export default {
  name: "UpdatePage",
  components: {
    HeaderComponent,
    UpdateFormComponent,
    FooterComponent,
  },
};
</script>

<style>
</style>