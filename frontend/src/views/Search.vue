<template lang="pug">
    .search
        search-card
        TODOCard
</template>

<script lang="ts">
    import SearchCard from "@/components/SearchCard.vue";
    import TODOCard from "@/components/todocard.vue";
    export default {
        name: "Search",
        components: {TODOCard, SearchCard}
    }
</script>

<style scoped>

</style>