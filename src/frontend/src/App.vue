<template>
  <div id="app">
    <navbar/>
    <page-welcome/>
  </div>
</template>

<script>
import Navbar from './elements/Navbar.vue'
import PageWelcome from "@/pages/PageWelcome";

export default {
  name: 'App',
  components: {
    PageWelcome,
    Navbar
  }
}
</script>

<style></style>
