## HTML Tags Overview

### Basic Structure:

- `<!DOCTYPE html>`: Declares the document type and version (HTML5 in this case).
- `<html>`: Root element of the HTML document.
- `<head>`: Contains meta-information about the document (title, character set, links to stylesheets, etc.).
- `<body>`: Contains the content of the document that will be visible on the web page.

### Text and Structure:

- `<h1> to <h6>`: Headings, with `<h1>` being the highest/most important and `<h6>` the lowest.
- `<p>`: Paragraph, used to define blocks of text.
- `<br>`: Line break, used to break the line and continue text on a new line.
- `<hr>`: Horizontal rule, creates a thematic break (a horizontal line).
- `<blockquote>`: Block of quoted text, typically with indented formatting.
- `<pre>`: Preformatted text, displays text with whitespace and line breaks preserved.

### Text Formatting:

- `<b>`: Bold text (not semantically emphasized).
- `<i>`: Italic text (not semantically emphasized).
- `<strong>`: Strong importance (typically renders as bold).
- `<em>`: Emphasized text (typically renders as italic).
- `<u>`: Underlined text.
- `<mark>`: Marked or highlighted text.
- `<small>`: Smaller text, typically used for side notes.
- `<sub>`: Subscript text.
- `<sup>`: Superscript text.

### Links and Navigation:

- `<a>`: Anchor, used to create hyperlinks.
  - Example: `<a href="https://example.com">Visit Example</a>`
- `<nav>`: Navigation section, typically contains links for navigating the website.

### Media:

- `<img>`: Image tag, used to display images.
  - Example: `<img src="image.jpg" alt="Image description">`
- `<audio>`: Embeds an audio file for playback.
  - Example: `<audio controls><source src="audio.mp3" type="audio/mp3"></audio>`
- `<video>`: Embeds a video for playback.
  - Example: `<video controls><source src="video.mp4" type="video/mp4"></video>`
- `<iframe>`: Embeds another HTML document, commonly used for embedding external content like YouTube videos or maps.

### Forms:

- `<form>`: Form element, used to collect user input.
  - Example: `<form action="/submit" method="POST">`
- `<input>`: Input field for text, buttons, checkboxes, radio buttons, etc.
  - Example: `<input type="text" name="username">`
- `<textarea>`: Multi-line text input.
- `<button>`: Button used to trigger actions or submit a form.
- `<select>`: Dropdown list of options.
- `<option>`: Option in a dropdown list.
- `<label>`: Label for form controls, improving accessibility.
- `<fieldset>`: Grouping related form elements, often with a border.
- `<legend>`: Defines a caption for a `<fieldset>`.

### Tables:

- `<table>`: Table container.
- `<tr>`: Table row.
- `<td>`: Table cell, used to hold data.
- `<th>`: Table header cell, bold and centered by default.
- `<thead>`: Grouping for the table header.
- `<tbody>`: Grouping for the table body (where data rows go).
- `<tfoot>`: Grouping for the table footer.

### Containers and Layout:

- `<div>`: Generic container for grouping content, commonly used for styling with CSS.
- `<span>`: Generic inline container for styling small sections of text or elements.
- `<section>`: Section of content, typically used to group thematic content.
- `<article>`: Represents a self-contained piece of content that can be distributed independently (e.g., blog post).
- `<header>`: Represents the introductory content for a page or section (usually contains a logo, nav, etc.).
- `<footer>`: Represents the footer of a page or section.
- `<aside>`: Represents content tangentially related to the content around it (like sidebars).
- `<main>`: Represents the main content of a document, typically unique and relevant to the page.

### Meta Information:

- `<meta>`: Provides metadata about the document (e.g., character set, author, description).
- `<title>`: Sets the title of the page that appears in the browser tab.
- `<link>`: Used to link external resources like stylesheets.
- `<style>`: Defines internal CSS for styling the page.
- `<script>`: Used to embed or link JavaScript code in a document.

### Time and Progress:

- `<time>`: Represents a specific time or date.
- `<code>`: Represents computer code (usually in a monospace font).
- `<pre>`: Preformatted text, typically preserving whitespace.
- `<progress>`: Represents the progress of a task.
- `<meter>`: Represents a scalar value within a known range (e.g., disk usage).

### Doctype Declaration:

- `<!DOCTYPE html>`: The `DOCTYPE` declaration is a document type declaration (or doctype) that tells the web browser which version of HTML it should expect to interpret and render.
  - **What It Does**: It instructs the browser on which HTML specification to follow when rendering the page. This helps ensure the page is displayed correctly across different browsers.
  - **Triggers Quirks Mode or Standards Mode**:
    - **Standards Mode**: If the doctype is correctly specified, the browser will render the page according to modern web standards.
    - **Quirks Mode**: If the doctype is missing or incorrect, browsers may render the page in "quirks" mode, which mimics older, non-standard behavior for legacy websites. This could lead to inconsistent rendering across browsers.
  - **Why `<!DOCTYPE html>` is Important**:
    - **HTML5**: `<!DOCTYPE html>` is the doctype for HTML5, which is the latest and current version of HTML. It's a simplified version compared to earlier versions of HTML.
    - For older versions like HTML 4.01, the doctype would look like:
      ```html
      <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
      ```
    - But in HTML5, we don't need the extra information. `<!DOCTYPE html>` is enough to let the browser know we're using HTML5.

### Box Model:

- **Box Model**: Defines the space around elements. The box model includes:
  - **Content**: The actual content (text, images, etc.).
  - **Padding**: Space between content and the border.
  - **Border**: Surrounds the content and padding.
  - **Margin**: Space between the element and adjacent elements.
