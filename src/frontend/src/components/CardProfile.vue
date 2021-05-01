<template>

  <div class="has-text-left">
    <b-field label="Date of birth *">
      <b-datepicker
          v-model="birthday"
          :max-date="new Date(new Date().setDate(new Date().getDate()-1))"
          editable
          trap-focus>
      </b-datepicker>
    </b-field>
    <b-field label="Address *">
      <b-input
          v-model="address"
          pattern="^(?!\s*$).+"
          required type="text"
          validation-message="Invalid address">
      </b-input>
    </b-field>
    <div class="field is-horizontal">
      <div class="field-body">
        <b-field label="City *">
          <b-input
              v-model="city"
              pattern="^(?!\s*$).+"
              required type="text"
              validation-message="Invalid city">
          </b-input>
        </b-field>
        <div class="field">
          <label class="label">State *</label>
          <div class="control">
            <div class="select">
              <select v-model="state">
                <option v-for="s in states" :key="s.id" v-bind:value="s.abbreviation">
                  {{ s.abbreviation }}
                </option>
              </select>
            </div>
          </div>
        </div>
        <b-field label="Zip Code *">
          <b-input
              v-model="zip"
              pattern="^[0-9]{5}(?:-[0-9]{4})?$"
              required type="text"
              validation-message="Invalid zipcode">
          </b-input>
        </b-field>
      </div>
    </div>
    <div class="field is-grouped is-grouped-centered mt-6">
      <p class="control">
        <button :disabled="isDisabled()" class="button is-success" v-on:click="save"> Save</button>
      </p>
      <p class="control">
        <router-link :to="{name: 'Welcome'}">
          <button class="button is-light">
            Cancel
          </button>
        </router-link>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "CardProfile",
  created() {
    this.$store.dispatch('loadStudent');
  },
  data() {
    return {
      address: '',
      city: '',
      state: '',
      zip: '',
      birthday: new Date(),
      states: [
        {name: 'ALABAMA', abbreviation: 'AL'},
        {name: 'ALASKA', abbreviation: 'AK'},
        {name: 'AMERICAN SAMOA', abbreviation: 'AS'},
        {name: 'ARIZONA', abbreviation: 'AZ'},
        {name: 'ARKANSAS', abbreviation: 'AR'},
        {name: 'CALIFORNIA', abbreviation: 'CA'},
        {name: 'COLORADO', abbreviation: 'CO'},
        {name: 'CONNECTICUT', abbreviation: 'CT'},
        {name: 'DELAWARE', abbreviation: 'DE'},
        {name: 'DISTRICT OF COLUMBIA', abbreviation: 'DC'},
        {name: 'FEDERATED STATES OF MICRONESIA', abbreviation: 'FM'},
        {name: 'FLORIDA', abbreviation: 'FL'},
        {name: 'GEORGIA', abbreviation: 'GA'},
        {name: 'GUAM', abbreviation: 'GU'},
        {name: 'HAWAII', abbreviation: 'HI'},
        {name: 'IDAHO', abbreviation: 'ID'},
        {name: 'ILLINOIS', abbreviation: 'IL'},
        {name: 'INDIANA', abbreviation: 'IN'},
        {name: 'IOWA', abbreviation: 'IA'},
        {name: 'KANSAS', abbreviation: 'KS'},
        {name: 'KENTUCKY', abbreviation: 'KY'},
        {name: 'LOUISIANA', abbreviation: 'LA'},
        {name: 'MAINE', abbreviation: 'ME'},
        {name: 'MARSHALL ISLANDS', abbreviation: 'MH'},
        {name: 'MARYLAND', abbreviation: 'MD'},
        {name: 'MASSACHUSETTS', abbreviation: 'MA'},
        {name: 'MICHIGAN', abbreviation: 'MI'},
        {name: 'MINNESOTA', abbreviation: 'MN'},
        {name: 'MISSISSIPPI', abbreviation: 'MS'},
        {name: 'MISSOURI', abbreviation: 'MO'},
        {name: 'MONTANA', abbreviation: 'MT'},
        {name: 'NEBRASKA', abbreviation: 'NE'},
        {name: 'NEVADA', abbreviation: 'NV'},
        {name: 'NEW HAMPSHIRE', abbreviation: 'NH'},
        {name: 'NEW JERSEY', abbreviation: 'NJ'},
        {name: 'NEW MEXICO', abbreviation: 'NM'},
        {name: 'NEW YORK', abbreviation: 'NY'},
        {name: 'NORTH CAROLINA', abbreviation: 'NC'},
        {name: 'NORTH DAKOTA', abbreviation: 'ND'},
        {name: 'NORTHERN MARIANA ISLANDS', abbreviation: 'MP'},
        {name: 'OHIO', abbreviation: 'OH'},
        {name: 'OKLAHOMA', abbreviation: 'OK'},
        {name: 'OREGON', abbreviation: 'OR'},
        {name: 'PALAU', abbreviation: 'PW'},
        {name: 'PENNSYLVANIA', abbreviation: 'PA'},
        {name: 'PUERTO RICO', abbreviation: 'PR'},
        {name: 'RHODE ISLAND', abbreviation: 'RI'},
        {name: 'SOUTH CAROLINA', abbreviation: 'SC'},
        {name: 'SOUTH DAKOTA', abbreviation: 'SD'},
        {name: 'TENNESSEE', abbreviation: 'TN'},
        {name: 'TEXAS', abbreviation: 'TX'},
        {name: 'UTAH', abbreviation: 'UT'},
        {name: 'VERMONT', abbreviation: 'VT'},
        {name: 'VIRGIN ISLANDS', abbreviation: 'VI'},
        {name: 'VIRGINIA', abbreviation: 'VA'},
        {name: 'WASHINGTON', abbreviation: 'WA'},
        {name: 'WEST VIRGINIA', abbreviation: 'WV'},
        {name: 'WISCONSIN', abbreviation: 'WI'},
        {name: 'WYOMING', abbreviation: 'WY'}
      ]
    }
  },
  computed: {
    student() {
      return this.$store.state.student;
    }
  },
  watch: {
    student() {
      this.address = this.student.address.split(", ")[0];
      this.city = this.student.address.split(", ")[1];
      this.state = this.student.address.split(", ")[2];
      this.zip = this.student.address.split(", ")[3];
      this.birthday = new Date(this.student.dob + "T00:00:00");
    }
  },
  methods: {
    save() {
      this.student.address = this.address + ", " + this.city + ", " + this.state + ", " + this.zip;
      this.student.dob = this.birthday.toISOString().substring(0, 10);
      this.$store.dispatch('saveStudent', this.student);
    },
    isDisabled() {
      return !this.address || !this.city || !this.zip;
    }
  }
}
</script>
