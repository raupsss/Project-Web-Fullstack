<template>
  <div>
    <HeaderComponent />
    <AddFormComponent />
    <FooterComponent />
  </div>
</template>

<script>
import HeaderComponent from "../components/HeaderComponent.vue";
import AddFormComponent from "../components/AddFormComponent.vue";
import FooterComponent from "../components/FooterComponent.vue";
export default {
  name: "AddPage",
  components: {
    HeaderComponent,
    AddFormComponent,
    FooterComponent,
  },
};
</script>

<style>
</style>