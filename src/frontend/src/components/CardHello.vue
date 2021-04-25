<template>
  <div>
    <h1 class="title is-1 has-text-link">Hello!</h1>
    <p>Welcome to the Student Registration Site
      <strong>
        Juliet Capulets
      </strong>
    </p>
    <router-link
        :to="{name : 'Registration'}"
        class="button is-link is-outlined mt-6">
      Register for a class
    </router-link>
  </div>
</template>

<script>
export default {
  name: "card-hello"
}
</script>