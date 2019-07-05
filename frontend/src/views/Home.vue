<template lang="pug">
 .home
   main-card
   TODOCard
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import HelloWorld from '@/components/HelloWorld.vue';
import MainCard from "@/components/maincard.vue";
import TODOCard from "@/components/todocard.vue"; // @ is an alias to /src

@Component({
  components: {
    TODOCard,
    MainCard,
    HelloWorld,
  },
})
export default class Home extends Vue {}
</script>
