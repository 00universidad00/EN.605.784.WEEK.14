<template>
  <div>
    <b-field>
      <b-datepicker
          icon="calendar-today"
          placeholder="Select Day of Birth"
          trap-focus
          type="day">
      </b-datepicker>
    </b-field>

    <div class="field is-horizontal">
      <div class="field-body">
        <div class="field">
          <p class="control is-expanded has-icons-left">
            <input class="input" placeholder="Name" type="text">
            <span class="icon is-small is-left">
              <i class="fas fa-user"></i>
            </span>
          </p>
        </div>
        <div class="field">
          <p class="control is-expanded has-icons-left has-icons-right">
            <input class="input" placeholder="Last" type="text">
            <span class="icon is-small is-left">
              <i class="fas fa-user"></i>
            </span>
          </p>
        </div>
      </div>
    </div>

    <div class="field is-horizontal">
      <div class="field-body">
        <div class="field">
          <p class="control is-expanded has-icons-left">
            <input class="input" placeholder="Name" type="text">
            <span class="icon is-small is-left">
              <i class="fas fa-user"></i>
            </span>
          </p>
        </div>
        <div class="field">
          <div class="control">
            <div class="select">
              <select>
                <option>Select dropdown</option>
                <option>With options</option>
              </select>
            </div>
          </div>
        </div>
        <div class="field">
          <p class="control is-expanded has-icons-left has-icons-right">
            <input class="input" placeholder="Last" type="text">
            <span class="icon is-small is-left">
              <i class="fas fa-user"></i>
            </span>
          </p>
        </div>
      </div>
    </div>

    <div class="field is-grouped is-grouped-centered mt-6">
      <p class="control">
        <a class="button is-success">
          Save
        </a>
      </p>
      <p class="control">
        <router-link :to="{name: 'Welcome'}">
          <a class="button is-light">
            Cancel
          </a>
        </router-link>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "CardProfile"
}
</script>

<style scoped>

</style>