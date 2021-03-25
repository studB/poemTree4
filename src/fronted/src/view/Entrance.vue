<template>
  <div>
      <div class="entrance">
          <router-link to="/note" custom v-slot="{ navigate }">
            <div @click="navigate" role="link">
                <span>Go note</span>
            </div>
          </router-link>
      </div>
  </div>
</template>

<script>
export default {
}
</script>

<style>

.entrance {
    width: 100vw;
    height: calc(100vh - var(--toolbarHeight));
    border: 1px solid orange;
    display: flex;
    justify-content: center;
    align-items: center;
}

.entrance > div {
    border: 1px solid green;
}

.entrance > div:hover{
    cursor: pointer;
}

.entrance > div > span {
    font-size: 3rem;
}

</style>