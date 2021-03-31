<template>
  <div>
      <div class="note" :class="mouseOn === 'left' ? 'note-inactive' : ''">
            <section class="list" :class="mouseOn === 'left' ? 'list-active' : ''" v-on:mouseenter="onLeft()">
                <note-list></note-list>
            </section>
            <section class="edit" :class="mouseOn === 'right' ? 'edit-active' : ''" v-on:mouseenter="onRight()">
                <editor></editor>
            </section>
      </div>
  </div>
</template>

<script>

import NoteList from '../components/list/NoteList.vue';
import Editor from '../components/edit/Editor.vue';

export default {
    name: 'note',
    components: {
        NoteList,
        Editor
    },
    data() {
        return {
            mouseOn : 'left'
        }
    },
    methods: {
        onLeft() {
            this.mouseOn = 'left';
        },
        onRight() {
            this.mouseOn = 'right';
        }
    }

}
</script>

<style>

.note {
    width: 100vw;
    height: calc(100vh - var(--toolbarHeight));
    border: 1px solid orange;
    display: flex;
    flex-direction: row;
}

.note-inactive {
    background-color: whitesmoke;
}

.note .list {
    width: 200px;
    min-width: 100px;
    max-width: 400px;
    height: inherit;
    border: 1px solid green;
    background-color: white;
}

.list-active {
    box-shadow: 7px 0 5px -5px rgba(0,0,0, 0.7);
}

.note .edit {
    flex: 1;
    border: 1px solid olivedrab;
}

.edit-active {
    box-shadow: -5px 0 8px -5px rgba(0,0,0,0.7);
}

.edit > div {
    border: 1px solid red;
}

</style>