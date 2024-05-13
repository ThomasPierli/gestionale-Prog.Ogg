// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyBWOCRtCmpN6yfY9G46oBNVAnnqbpQ67Zc",
  authDomain: "javaprojpao.firebaseapp.com",
  databaseURL: "https://javaprojpao-default-rtdb.europe-west1.firebasedatabase.app",
  projectId: "javaprojpao",
  storageBucket: "javaprojpao.appspot.com",
  messagingSenderId: "772161603857",
  appId: "1:772161603857:web:a1c9c08373126308f364b0",
  measurementId: "G-L582YG246G"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);