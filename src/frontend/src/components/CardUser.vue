<template>
  <div class="card">
    <div class="card-image has-background-light">
      <figure class="image is-4by3">
        <img class="py-6 px-6" alt="Placeholder image" src="../assets/images/juliet.svg">
      </figure>
    </div>
    <div class="card-content has-text-left">
      <div class="media">
        <div class="media-content">
          <p class="title is-4">{{ student.first }} {{ student.last }}</p>
          <p class="subtitle is-6">@{{ student.id }}</p>
          <div>
            <label class="label">Date of birth <p class="subtitle is-6">{{ student.dob }}</p></label>
            <label class="label">Address <p class="subtitle is-6">{{ student.address }}</p></label>

          </div>
        </div>
      </div>
      <div class="content has-text-right">
        <router-link :to="{name: 'Profile'}">
          <button class="button is-ghost px-0 py-0">Edit Profile</button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import {mapState} from "vuex";

export default {
  name: "card-user",
  computed: {
    ...mapState(['student'])
  },
  created() {
    this.$store.dispatch('loadStudent');
  }
}
</script>