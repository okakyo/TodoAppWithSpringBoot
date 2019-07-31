<template lang="pug">
 .home
   main-card
   TODOCard
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import MainCard from "@/components/maincard.vue";
import TODOCard from "@/components/todocard.vue"; // @ is an alias to /src

@Component({
  components: {
    TODOCard,
    MainCard,

  },
})
export default class Home extends Vue {


}
</script>
