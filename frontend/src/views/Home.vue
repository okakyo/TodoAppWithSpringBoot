<template lang="pug">
 .home
   main-card

</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import HelloWorld from '@/components/HelloWorld.vue';
import MainCard from "@/components/maincard.vue"; // @ is an alias to /src

@Component({
  components: {
    MainCard,
    HelloWorld,
  },
})
export default class Home extends Vue {}
</script>
