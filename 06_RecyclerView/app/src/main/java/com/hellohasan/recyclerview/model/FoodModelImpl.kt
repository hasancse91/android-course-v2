package com.hellohasan.recyclerview.model

class FoodModelImpl : FoodModel {

    override fun getFoodList(): MutableList<Food> {
        val foodList = mutableListOf<Food>()

        for (i in 1..10) {
            val food = Food(
                i*101,
                "Pizza Italiano",
                250,
                i % 2 == 0,
                "https://static.toiimg.com/photo/53110049.cms",
                4.8F,
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                "Mom's Kitchen"
            )
            foodList.add(food)
        }
        return foodList
    }

    override fun getFoodItemById(id: Int): Food {

        val foodList = getFoodList()

        foodList.forEach {
            if (it.id == id)
                return it
        }

        return Food(
            101,
            "Pizza Italiano",
            250,
            true,
            "https://static.toiimg.com/photo/53110049.cms",
            4.8F,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
            "Mom's Kitchen"
        )

    }

}