<template>
  <Body>
  <p class="title is-3 has-text-link mb-6">Course Registration</p>
  <div class="field is-grouped">
    <div class="control is-expanded">
      <div class="select is-fullwidth">
        <select v-model="selected">
          <option v-for="course in courses" :key="course.id" v-bind:value="course.id">
            {{ course.id }} - {{ course.name }}
          </option>
        </select>
      </div>
    </div>
    <p class="control">
      <button class="button is-success" v-on:click="register">Register</button>
    </p>
    <p class="control">
      <router-link :to="{name: 'Welcome'}">
        <button class="button is-danger is-light">Cancel</button>
      </router-link>
    </p>
  </div>
  </Body>
</template>

<script>
import Body from "@/elements/Body";
import {mapState} from "vuex";

export default {
  name: "PageRegistration",
  components: {Body},
  created() {
    this.$store.dispatch('loadCourses');
    this.$store.dispatch('loadStudent');
  },
  data() {
    return {
      selected: '',
    }
  },
  computed: {
    ...mapState(['courses']),
    ...mapState(['student'])
  },
  methods: {
    register() {
      console.log(this.selected);
      this.$store.dispatch('registerStudent', this.student.id + "/to/" + this.selected);
    }
  }
}
</script>