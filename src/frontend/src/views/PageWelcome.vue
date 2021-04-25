<template>
  <Body>
    <Grid>
      <template v-slot:column-1>
        <CardUser/>
      </template>
      <template v-slot:column-2>
        <CardHello/>
      </template>
    </Grid>
  </Body>
</template>

<script>
import Grid from "@/elements/Grid";
import CardUser from "@/components/CardUser";
import CardHello from "@/components/CardHello";
import Body from "@/elements/Body";

export default {
  name: "PageWelcome",
  components: {Body, CardHello, CardUser, Grid}
}
</script>