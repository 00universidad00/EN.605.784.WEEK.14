<template>
  <Body>
  <Grid>
    <template v-slot:column-1>
      <CardUser/>
    </template>
    <template v-slot:column-2>
      <CardProfile/>
    </template>
  </Grid>
  </Body>
</template>

<script>
import Body from "@/elements/Body";
import Grid from "@/elements/Grid";
import CardUser from "@/components/CardUser";
import CardProfile from "@/components/CardProfile";

export default {
  name: "PageProfile",
  components: {CardProfile, CardUser, Grid, Body}
}
</script>