<template>
  <b-navbar>
    <template #brand>
      <router-link :to="{name: 'Welcome'}">
        <b-navbar-item>
          <img src="../assets/images/logo.svg">
          <span class="title is-4 ml-2">SRS</span>
        </b-navbar-item>
      </router-link>
    </template>
  </b-navbar>
</template>

<script>
export default {
  name: "Navbar"
}
</script>