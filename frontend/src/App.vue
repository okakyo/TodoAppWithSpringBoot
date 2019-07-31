<template lang="pug">
  v-app
    Header
    v-container
        v-content
          router-view
</template>

<script>
import Header from './components/header'
export default {
  name: 'App',
  components: {
    Header
  },
  data () {
    return {
      //
    }
  }
}
</script>
