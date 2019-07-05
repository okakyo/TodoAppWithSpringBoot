<template lang="pug">
    v-toolbar(app color="indigo")
        v-toolbar-title
           router-link.headers-router(to="/")
               h2.white--text.mr-2 TODOリスト

        v-spacer
        router-link.headers-router(to="/search")
            h2.white--text.mr-2 検索

</template>

<script lang="ts">

    export default {
        name: "Header"
    }
</script>

<style scoped>
   .headers-router {
       text-decoration: none;
   }


</style>