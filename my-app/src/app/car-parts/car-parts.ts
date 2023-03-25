export class CarPart {
    id: number;
    name: string;
    description: string;
    inStock: number;
    price: number;
    image: string;
    featured: boolean;
    quantity: number;

    constructor(id: number, name: string, description: string, inStock: number,
        price: number, image: string, featured: boolean, quantity: number) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.inStock = inStock;
            this.price = price;
            this.image = image;
            this.featured = featured;
            this.quantity = quantity;
    }
}