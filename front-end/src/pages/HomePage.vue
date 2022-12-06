<template>
  <div>
    <HeaderComponent />
    <ViewDataComponent />
    <FooterComponent />
  </div>
</template>

<script>
import HeaderComponent from "../components/HeaderComponent.vue";
import ViewDataComponent from "../components/ViewDataComponent.vue";
import FooterComponent from "../components/FooterComponent.vue";
export default {
  name: "HomePage",
  components: {
    HeaderComponent,
    ViewDataComponent,
    FooterComponent,
  },
};
</script>

<style>
</style>