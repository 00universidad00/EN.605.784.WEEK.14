<template>
  <section>
    <b-modal
        :active="isModalActive"
        :destroy-on-hide="false"
        :on-cancel="closeModal"
        aria-label="Example Modal"
        aria-modal
        aria-role="dialog"
        has-modal-card
        trap-focus>
      <template>
        <b-message title="Dark with custom icon" type="is-dark" has-icon icon="account" aria-close-label="Close message">
          Lorem ipsum dolor sit amet, consectetur warning elit. Fusce id fermentum quam. Proin sagittis, nibh id hendrerit imperdiet, elit sapien laoreet elit
        </b-message>
      </template>
    </b-modal>
  </section>
</template>

<script>
import {mapActions, mapGetters} from "vuex";

export default {
  name: "Modal",
  components: {},
  computed: {
    ...mapGetters({
      isModalActive: 'notification/isActive'
    })
  },
  methods: {
    ...mapActions({
      closeModal: 'notification/hide'
    }),
    alertCustom() {
      this.$buefy.dialog.alert({
        title: 'Title Alert',
        message: 'I have a title, a custom button and <b>HTML</b>!',
        confirmText: 'Cool!'
      })
    },
  }
}
</script>