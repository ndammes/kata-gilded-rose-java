package com.gildedrose;

class GildedRose {
    private static final String BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (int i = 0; i < items.length; i++) {
            switch (items[i].name) {
                case BRIE:
                    handleBrie(i);
                    break;
                case BACKSTAGE:
                    handleBackstage(i);
                    break;
                case SULFURAS:
                    break;
                default:
                    handleOthers(i);
                    break;
            }
        }
    }

    private void increaseQuality(int index) {
        if (items[index].quality < 50) {
            items[index].quality = items[index].quality + 1;
        }
    }

    private void reduceQuality(int index) {
        if (items[index].quality > 0) {
            items[index].quality = items[index].quality - 1;
        }
    }

    private void reduceSellin(int index) {
        items[index].sellIn = items[index].sellIn - 1;
    }

    private void handleBrie(int index) {
        increaseQuality(index);
        reduceSellin(index);

        if(items[index].sellIn < 0) {
            increaseQuality(index);
        }
    }

    private void handleBackstage(int index) {
        increaseQuality(index);

        if(items[index].sellIn < 11) {
            increaseQuality(index);
        }
        if(items[index].sellIn < 6) {
            increaseQuality(index);
        }
        
        
        reduceSellin(index);
        if(items[index].sellIn < 0) {
            items[index].quality = 0;
        }
    }

    private void handleOthers(int index) {
        reduceQuality(index);
        reduceSellin(index);
        if(items[index].sellIn < 0) {
            reduceQuality(index);
        }
    } 
}