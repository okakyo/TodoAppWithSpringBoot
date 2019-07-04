<template lang="pug">
  v-app
    Header
    v-container
        v-content
          router-view
</template>

<script>
import HelloWorld from './components/HelloWorld'
import Header from './components/header'
export default {
  name: 'App',
  components: {
    HelloWorld,Header
  },
  data () {
    return {
      //
    }
  }
}
</script>
