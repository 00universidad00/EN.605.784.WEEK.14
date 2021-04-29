<template>
  <section class="hero is-white is-fullheight-with-navbar">
    <div class="hero-body">
      <div class="container is-max-desktop has-text-centered">
        <!--        <Modal/>-->
<!--        <Message/>-->
        <slot></slot>
      </div>
    </div>
  </section>
</template>

<script>
// import Message from "@/elements/Message";

export default {
  name: "Body",
  // components: {Message}
}
</script>

<style scoped>

</style>