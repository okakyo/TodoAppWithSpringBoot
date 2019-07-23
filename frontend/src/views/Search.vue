<template lang="pug">
    .search
        search-card
        show
</template>

<script lang="ts">
    import SearchCard from "@/components/SearchCard.vue";
    import show from "@/components/show.vue";
    export default {
        name: "Search",
        components: {show, SearchCard}
    }
</script>

<style scoped>

</style>
