import React from 'react'
import { useReducer } from 'react'

function reducer(state, action) {
    switch (action.type) {
        case 'add': {
            const id = action.payload.id;
            const cost = action.payload.cost;
            const exi = state.items.find(item => item.id === id);
            let newItems;
            if (exi) {
                newItems = state.items.map(item => {
                    if (item.id === id) {
                        return { ...item, count: item.count + 1 }
                    }
                    return item;
                })
            } else {
                newItems = [...state.items, { id: id, name: action.payload.name, cost: cost, count: 1 }]
            }
            return {
                ...state,
                items: newItems,
                totcost: state.totcost + cost
            }
        }
        case 'remove': {
            const id = action.payload.id;
            const cost = action.payload.cost;
            const exi = state.items.find(item => item.id === id);
            let newItems;
            if (exi.count > 1) {
                newItems = state.items.map(item => {
                    if (item.id === id) {
                        return { ...item, count: item.count - 1 }
                    }
                    return item;
                })
            } else {
                newItems = state.items.filter(item => item.id !== id);
            }
            return {
                ...state,
                items: newItems,
                totcost: state.totcost - cost
            }
        }
        default:
            return state;
    }
}

function ShoppingCart() {
    const [cart, dispatchCart] = useReducer(reducer, {
        items: [],
        totcost: 0,
    })

    const dummyProducts = [
        { id: 1, name: 'product1', cost: 100 },
        { id: 2, name: 'product2', cost: 200 },
        { id: 3, name: 'product3', cost: 300 },
        { id: 4, name: 'product4', cost: 400 },
    ]

    const containerStyle = {
        maxWidth: '800px',
        margin: '0 auto',
        padding: '20px',
        fontFamily: 'Arial, sans-serif',
    }

    const cardStyle = {
        border: '1px solid #ccc',
        borderRadius: '8px',
        padding: '15px',
        margin: '10px 0',
        boxShadow: '0 2px 5px rgba(0,0,0,0.1)',
    }

    const buttonStyle = {
        padding: '8px 12px',
        marginTop: '10px',
        backgroundColor: '#007bff',
        color: '#fff',
        border: 'none',
        borderRadius: '4px',
        cursor: 'pointer',
    }

    const sectionTitle = {
        borderBottom: '2px solid #007bff',
        paddingBottom: '5px',
        marginTop: '30px',
    }

    return (
        <div style={containerStyle}>
            <h1>Shopping Cart</h1>
            {dummyProducts.map((product) => (
                <div key={product.id} style={cardStyle}>
                    <h2>{product.name}</h2>
                    <p>Cost: ₹{product.cost}</p>
                    <button
                        style={buttonStyle}
                        onClick={() =>
                            dispatchCart({
                                type: 'add',
                                payload: {
                                    id: product.id,
                                    name: product.name,
                                    cost: product.cost,
                                },
                            })
                        }
                    >
                        Add to Cart
                    </button>
                </div>
            ))}
            <h1 style={sectionTitle}>My Cart</h1>
            {cart.items.length === 0 && <p>No items in cart.</p>}
            {cart.items.map((item) => (
                <div key={item.id} style={cardStyle}>
                    <h2>{item.name}</h2>
                    <p>Cost: ₹{item.cost}</p>
                    <p>Count: {item.count}</p>
                    <button
                        style={{ ...buttonStyle, backgroundColor: '#dc3545' }}
                        onClick={() =>
                            dispatchCart({
                                type: 'remove',
                                payload: { id: item.id, cost: item.cost },
                            })
                        }
                    >
                        Remove from Cart
                    </button>
                </div>
            ))}
            <h2 style={{ marginTop: '20px' }}>Total Cost: ₹{cart.totcost}</h2>
        </div>
    )
}

export default ShoppingCart
