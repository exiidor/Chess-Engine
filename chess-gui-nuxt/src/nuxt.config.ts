// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
	compatibilityDate: '2024-11-01',
	future: {
		compatibilityVersion: 4,
	},
	devtools: { enabled: true },
	modules: [
		'@vueuse/nuxt',
	],
	imports: {
		dirs: [
			'enums',
		]
	},
	nitro: {
		experimental: {
			websocket: true,
		},
	},
	vite: {
		server: {
			allowedHosts: true
		}
	},
	runtimeConfig: {
		public: {
			chessServerAddress: "ws://localhost:3010",
		}
	}
})
