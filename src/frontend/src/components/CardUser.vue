<template>
  <div class="card">
    <div class="card-image pt-6 px-6">
      <figure class="image is-4by3">
        <img alt="Placeholder image" src="../assets/images/juliet.svg">
      </figure>
    </div>
    <div class="card-content">
      <div class="media">
        <div class="media-content">
          <p class="title is-4">Juliet Capulets</p>
          <p class="subtitle is-6">@juliet1234</p>
        </div>
      </div>
      <div class="content">
        <router-link :to="{name: 'Profile'}"><button class="button is-ghost">Edit Profile</button></router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "card-user"
}
</script>

<style scoped>

</style>