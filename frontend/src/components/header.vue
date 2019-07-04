<template lang="pug">
    v-toolbar(app)

      v-toolbar-title.headline.text-uppercase
        span Todoリスト

      v-spacer
      v-btn(flat href="https://github.com/vuetifyjs/vuetify/releases/latest" target="_blank")
        span(class="mr-2") 検索

</template>

<script lang="ts">

    export default {
        name: "Header"
    }
</script>

<style scoped>

</style>