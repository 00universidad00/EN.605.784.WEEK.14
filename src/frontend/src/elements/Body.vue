<template>
  <section class="hero is-white is-fullheight-with-navbar">
    <div class="hero-body">
      <div class="container is-max-desktop has-text-centered">
        <slot></slot>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "Body"
}
</script>

<style scoped>

</style>