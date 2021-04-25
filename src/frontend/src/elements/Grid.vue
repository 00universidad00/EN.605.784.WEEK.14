<template>
  <div class="columns is-vcentered is-variable is-8">
    <div class="column">
      <slot name='column-1'></slot>
    </div>
    <div class="column has-text-centered">
      <slot name='column-2'></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: "Grid"
}
</script>

<style scoped>

</style>