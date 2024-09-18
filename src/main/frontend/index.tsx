import {router} from 'Frontend/generated/routes.js';
import {RouterProvider} from 'react-router-dom';
import {createRoot} from 'react-dom/client';
import React, {createElement} from 'react';

function App() {
    return (
        <RouterProvider router={router}/>
    );
}

createRoot(document.getElementById('outlet')!).render(createElement(App));
