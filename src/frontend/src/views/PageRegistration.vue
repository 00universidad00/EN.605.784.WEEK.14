<template>
  <Body>
  <p class="title is-3 has-text-link mb-6">Course Registration</p>
  <div class="field is-grouped">
    <div class="control is-expanded">
      <div class="select is-fullwidth">
        <Select value="#{registrationController.selectedCourseId}">
        </Select>
      </div>
    </div>
    <p class="control">
      <button class="button is-success">Register</button>
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

export default {
  name: "PageRegistration",
  components: {Body}
}
</script>