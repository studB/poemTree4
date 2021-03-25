<template>
  <div id="app">
    <tool-bar></tool-bar>
    <section>
      <router-view></router-view>
    </section>
  </div>
</template>

<script>
import ToolBar from './components/ToolBar.vue'

export default {
  name: 'App',
  components: {
    ToolBar
  },
  mounted(){
    document.getElementById('app').style.setProperty('--toolbarHeight', this.$store.state.toolbarHeight);
  }
}
</script>

<style>

* {
 margin: 0;
 padding: 0;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

#app > section {
  position: fixed;
  top: var(--toolbarHeight);
}

</style>
